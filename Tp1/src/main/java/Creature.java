public class Creature {
    public static final int MAX_VAL = 100;
    private String nom;
    private int attaque;
    private int defense;
    private int pointDeVie;

    public Creature() {
        this("", 0, 0, MAX_VAL);
    }

    public Creature(String nom, int attaque, int defense, int pointDeVie) {
        this.nom = nom;
        this.attaque = attaque;
        this.defense = defense;
        if (pointDeVie < 0) {
            this.pointDeVie = 0;
        } else if (pointDeVie > MAX_VAL) {
            this.pointDeVie = MAX_VAL;
        } else {
            this.pointDeVie = pointDeVie;
        }
    }

    public Creature(String nom, int attaque, int defense) {
        this.nom = nom;
        this.attaque = attaque;
        this.defense = defense;
        this.pointDeVie = MAX_VAL;
    }

    public Creature(Creature c) {
        this.nom = c.nom;
        this.attaque = c.attaque;
        this.defense = c.defense;
        this.pointDeVie = c.pointDeVie;
    }

    public String getNom() {
        return nom;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getDefense() {
        return defense;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setPointDeVie(int pointDeVie) {
        if (pointDeVie < 0) {
            this.pointDeVie = 0;
        } else if (pointDeVie > MAX_VAL) {
            this.pointDeVie = MAX_VAL;
        } else {
            this.pointDeVie = pointDeVie;
        }
    }

    public void setPointDeVie(int pointDeVie, boolean estPositive) {
        if (estPositive) {
            this.pointDeVie += pointDeVie;
            if (this.pointDeVie > MAX_VAL) {
                this.pointDeVie = MAX_VAL;
            }
        } else {
            this.pointDeVie -= pointDeVie;
            if (this.pointDeVie < 0) {
                this.pointDeVie = 0;
            }
        }
    }

    public void attaquer(Creature creature) {
        int dommages = this.attaque - creature.getDefense();
        if (dommages > 0) {
            creature.setPointDeVie(creature.getPointDeVie() - dommages);
            if (creature.getPointDeVie() < 0) {
                creature.setPointDeVie(0);
            }
        }
    }
    public void attaquer(Creature creature, int attaqueBonus) {
        int dommages = this.attaque - creature.getDefense() + attaqueBonus;
        if (dommages > 0) {
            creature.setPointDeVie(creature.getPointDeVie() - dommages);
            if (creature.getPointDeVie() < 0) {
                creature.setPointDeVie(0);
            }
        }
    }


    public void defendre(Creature creature) {
        int dommages = creature.getAttaque() - this.defense;
        if (dommages > 0) {
            this.setPointDeVie(this.getPointDeVie() - dommages);
            if (this.getPointDeVie() < 0) {
                this.setPointDeVie(0);
            }
        }
    }

    public void defendre(Creature creature, int defenseBonus) {
        int dommages = creature.getAttaque() - (this.defense + defenseBonus);

        if (dommages > 0) {
            this.setPointDeVie(this.getPointDeVie() - dommages, true);
        }
    }

    public boolean estAffaibli() {
        return this.pointDeVie == 0;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Creature creature = (Creature) obj;
        if (attaque != creature.attaque) return false;
        if (defense != creature.defense) return false;
        if (pointDeVie != creature.pointDeVie) return false;
        if (nom == null && creature.nom != null) return false;
        if (nom != null && !nom.equals(creature.nom)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Attaque: " + attaque + ", Défense: " + defense + ", Points de Vie: " + pointDeVie;
    }



}
