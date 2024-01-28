public class CreatureMagique extends Creature{
    private int forceMagique;
    private boolean aPotionMagique;
    private boolean estMagique;

    public static final int PERTE_MAGIQUE = 5;

    public CreatureMagique(){
        super("", 0, 0, MAX_VAL);
        forceMagique = 0;
        aPotionMagique = false;
        estMagique = false;
    }

    public CreatureMagique(final String nom, int attaque, int defense, int pointDeVie, int forceMagique, boolean aPotionMagique, boolean estMagique){
        super(nom, attaque, defense, pointDeVie);
        this.forceMagique = forceMagique;
        this.aPotionMagique = aPotionMagique;
        this.estMagique = estMagique;
    }

    public CreatureMagique(final Creature creature, int forceMagique,  boolean aPotionMagique, boolean estMagique){
        super(creature);
        this.forceMagique = forceMagique;
        this.aPotionMagique = aPotionMagique;
        this.estMagique = estMagique;
    }

    public CreatureMagique(final CreatureMagique cm){
        super(cm);
        this.forceMagique = cm.forceMagique;
        this.estMagique = cm.estMagique;
        this.aPotionMagique = cm.aPotionMagique;
    }
    public final int getForceMagique(){
        return forceMagique;
    }

    public final boolean getAPotionMagique(){
        return aPotionMagique;
    }

    public final boolean getEstMagique(){
        return estMagique;
    }

    public void setForceMagique(int forceMagique){
        this.forceMagique = forceMagique;
    }

    public void setForceMagique(int forceMagique, boolean estPositive){
        if(estPositive){
            this.forceMagique += forceMagique;
        }
        else{
            this.forceMagique -= forceMagique;
        }
    }

    @Override
    public void attaquer(Creature creature){
        if(estMagique){
            attaquer(creature, this.forceMagique);
        }
        else{
            super.attaquer(creature);
        }
    }

    @Override
    public void attaquer(Creature creature, int forceMagique){
        int bonus = this.getAttaque() * forceMagique/ 100;
        super.attaquer(creature, bonus);
        this.forceMagique -= PERTE_MAGIQUE;
    }

    @Override
    public void defendre(Creature creature){
        if(estMagique){
            creature.attaquer(creature);
        }
        super.defendre(creature);
    }

    public void utiliserPotionMagique(){
        setPointDeVie(MAX_VAL);

        estMagique = true;
        aPotionMagique = false;
    }

    public void afficher(){
        System.out.print(toString());
    }

    @Override
    public String toString(){
        return "[Creature Magique] -> " + super.toString() + ", Force Magique: " +forceMagique;
    }

}