public class RobinHoodHashTable<AnyType> extends QuadraticProbingHashTable<AnyType> {
    public RobinHoodHashTable(){
        super();
    }

    public RobinHoodHashTable(int size){
        super(size);}

    //Je sais pas si c'est bon
    //Recommandé mais pas obligatoire ( cette methode n'est pas un override)
    /*
    private int findPos(HashEntry<AnyType> x) {
    }
    */

    protected int numberOfCollision = 0;

    private void insert (HashEntry<AnyType> x) {
        boolean isSwapLeft = true;
        int offset = 1;
        HashEntry<AnyType> entryToPlace = x;

        int currentPos = myhash(entryToPlace.element);

        if(contains(entryToPlace.element) != -1)
            return;

        while (isSwapLeft){

            while (array[currentPos] != null
                    && entryToPlace.probeDistance <= array[currentPos].probeDistance){
                numberOfCollision++;
                currentPos += offset;
                offset += 2;
                entryToPlace.probeDistance += 1;
                while (currentPos >= array.length)
                    currentPos -= array.length;

            }

            //on fait un swap
            if (array[currentPos] != null){
                offset = entryToPlace.probeDistance;
                HashEntry<AnyType> tempHashentry = array[currentPos];
                array[currentPos] = entryToPlace;
                entryToPlace = tempHashentry;
                if(!entryToPlace.isActive)
                    return;
            }
            //plus de swap à faire
            else{
                array[currentPos] = new HashEntry<AnyType>(entryToPlace.element, true);
                array[currentPos].probeDistance = entryToPlace.probeDistance;
                if (++currentSize > array.length * 0.5)
                    rehash();
                isSwapLeft = false;
            }
        }
    }

    @Override
    public int contains (AnyType x) {
        int currentPos = super.findPos( x );
        return isActive( currentPos )?currentPos:-1;
    }

    @Override
    public void insert (AnyType x){
        HashEntry X = new HashEntry<>(x);
        this.insert(X);
    }

}

/*Mettre ici votre réponse pour executionTimeTest

Pour la table de hashage RobinHood, le nombre de collisions est environ deux fois moins élevés qu'avec
le quadratic probing, ce qui constitue en soit un avantage car les données se trouvent plus près de
leur position de hashage originale. Un désavantage que RobinHood prend presque autant de temps que la
QuadraticProbing à faire le contain de la table, malgré la complexité de l'inplémentation de la table
qui est plus complexe que celle de la QuadraticProbing. Avec 282000 nanoseconde de moins pour le temps
d'exécution, on peut se demander si l'implémentation plus complexe vaut la peine selon les différentes
applications.

En ce qui concerne, la table QuadraticProbing, les avantages et désavantages sont inversement analogue
à la table RobinHood, le nombre de collision est environ deux fois plus grand, signifiant que les éléments
sont plus loin de leur possition de hashage originale mais le temps d'exécution est similaire à celui de
la table RobinHood avec un implémentation qui est plus simple.

* 1. RH : 106060700 ns
*    QP : 95141800
* 2. RH : 103769400
*    QP : 119768500
* 3. Robin Hood HashTable took: 106591900 nanoseconds
     Quadratic Probing HashTable took: 101823500 nanoseconds
* 4. Robin Hood HashTable took: 97214000 nanoseconds
     Quadratic Probing HashTable took: 99625600 nanoseconds
* 5. Robin Hood HashTable took: 94021400 nanoseconds
     Quadratic Probing HashTable took: 100437200 nanoseconds
* 6. Robin Hood HashTable took: 92014800 nanoseconds
     Quadratic Probing HashTable took: 96189700 nanoseconds
* 7. Robin Hood HashTable took: 100735700 nanoseconds
     Quadratic Probing HashTable took: 94926700 nanoseconds
* 8. Robin Hood HashTable took: 104795300 nanoseconds
     Quadratic Probing HashTable took: 97922900 nanoseconds
* 9. Robin Hood HashTable took: 103237600 nanoseconds
     Quadratic Probing HashTable took: 103171500 nanoseconds
* 10.Robin Hood HashTable took: 101230200 nanoseconds
     Quadratic Probing HashTable took: 103483600 nanoseconds
*
* Temps moyen RH : 100967100 ns
* Temps moyen QP : 101249100 ns

*
*
* */


