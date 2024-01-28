import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Polyland {
    private List<Dresseur> dresseurs;
    private List<Creature> creatures;

    public Polyland(){
        dresseurs = new ArrayList<>();
        creatures = new ArrayList<>();
    }
    public boolean ajouterDresseur(Dresseur dresseur){
        if(!dresseurs.contains(dresseur)){
            dresseurs.add(dresseur);
            return true;
        }
            return false;
        }
    public boolean ajouterCreature(Creature creature){
        if(!creatures.contains(creature)){
            creatures.add(creature);
            return true;
        }
        return false;
    }
    public boolean retirerDresseur(final String nom) {
        for (Dresseur dresseur : dresseurs) {
            if (dresseur.getNom().equals(nom)) {
                dresseurs.remove(dresseur);
                return true;
            }
        }
        return false;
    }
    public boolean retirerCreature(final String nom) {
        for (Creature creature : creatures) {
            if (creature.getNom().equals(nom)) {
                creatures.remove(creature);
                return true;
            }
        }
        return false;
    }
    public Dresseur trouverDresseur(final String nom) {
        for (Dresseur dresseur : dresseurs) {
            if (dresseur.getNom().equals(nom)) {
                return dresseur;
            }
        }
        return null;
    }
    public Creature trouverCreature(final String nom){
        for (Creature creature : creatures){
            if(creature.getNom().equals(nom)){
                return creature;
            }
        }
        return null;
    }
    public Creature choisirCreatureAleatoire() {
        if (creatures.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(creatures.size());
        return creatures.get(randomIndex);
    }



    public Dresseur choisirDresseurAleatoire(){
        if (dresseurs.isEmpty()){
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(dresseurs.size());
        Dresseur chosenDresseur = new Dresseur(dresseurs.get(randomIndex));
        return chosenDresseur;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PolyLand:\n");
        builder.append("Dresseurs:\n");
        for (Dresseur dresseur : dresseurs) {
            builder.append(dresseur).append("\n");
        }
        builder.append("Creatures sans dresseur:\n");
        for (Creature creature : creatures) {
            boolean isAssigned = false;
            for (Dresseur dresseur : dresseurs) {
                if (dresseur.getCreatures().contains(creature)) {
                    isAssigned = true;
                    break;
                }
            }
            if (!isAssigned) {
                builder.append(creature).append("\n");
            }
        }

        return builder.toString();
    }
}

