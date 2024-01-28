public class CreatureExperience extends Creature implements Experience {

    // Instance Variables
    private int forceExp;

    // Constants
    public static final int MAX_VAL = 100;

    // Constructors
    public CreatureExperience() {
        super("", 0, 0, 0);
        this.forceExp = 0;
    }

    public CreatureExperience(String nom, int attaque, int defense, int pointDeVie, int forceExp) {
        super(nom, attaque, defense, pointDeVie);
        this.forceExp = forceExp;
    }

    public CreatureExperience(Creature creature, int forceExp) {
        super(creature);
        this.forceExp = forceExp;
    }

    public CreatureExperience(CreatureExperience ce) {
        super(ce);
        this.forceExp = ce.forceExp;
    }

    @Override
    public void afficher() {

    }

    @Override
    public int obtenirExperience() {
        return this.forceExp;
    }

    // Getters and setters
    public int getExperience() {
        return this.forceExp;
    }

    public void setExperience(int exp) {
        this.forceExp = Math.min(MAX_VAL, Math.max(0, exp));
    }

    public void setExperience(int exp, boolean estPositive) {
        if (estPositive) {
            this.forceExp = Math.min(MAX_VAL, this.forceExp + exp);
        } else {
            this.forceExp = Math.max(0, this.forceExp - exp);
        }
    }

    // Override methods
    @Override
    public void attaquer(Creature creature) {
        super.attaquer(creature);
    }

    @Override
    public void attaquer(Creature creature, int expBonus) {
        int bonus = getAttaque() * ((forceExp + expBonus) / 100);
        super.attaquer(creature, bonus);
    }
    public void defendre(Creature creature) {
        int defenseBonus = (int)((getDefense() * (getExperience() / 100.0)));
        int dommage = creature.getAttaque() - (getDefense() + defenseBonus);
        int newPointDeVie = getPointDeVie() - dommage;

        // Ensure the newPointDeVie does not go below zero
        if (newPointDeVie < 0) {
            newPointDeVie = 0;
        }

        setPointDeVie(newPointDeVie);
    }

    public void defendre(Creature creature, int expBonus) {
        int defenseBonus = (int)((getDefense() * ((getExperience() + expBonus) / 100.0)));
        int dommage = creature.getAttaque() - (getDefense() + defenseBonus);
        int newPointDeVie = getPointDeVie() - dommage;

        // Ensure the newPointDeVie does not go below zero
        if (newPointDeVie < 0) {
            newPointDeVie = 0;
        }

        setPointDeVie(newPointDeVie);
        setExperience(getExperience() - expBonus);
    }


    @Override
    public String toString() {
        return "[Creature Experience] -> Nom: " + getNom() + ", Attaque: " + getAttaque() +
                ", Défense: " + getDefense() + ", Points de Vie: " + getPointDeVie() +
                ", Force Experience: " + getExperience();
    }

}
