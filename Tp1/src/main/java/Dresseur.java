import java.util.ArrayList;
import java.util.Objects;

public class Dresseur {
    protected  String nom_ ;
   protected ArrayList<Creature> creatures_ = new ArrayList<Creature>();

   public Dresseur(final String nom){
       nom_ = nom;
   }

   public  Dresseur( Dresseur d){
       this.nom_ = d.nom_;
       for(Creature creature: d.creatures_){
           ajouterCreature(new Creature(creature));
       }
   }

   public String getNom(){
       return nom_;
   }

   public void setNom(final String nom){
       nom_ = nom;
   }

   public void setCreatures( final ArrayList<Creature> creatures){
       creatures_ = creatures;
   }

  public final int getNombreCreatures() {
      return creatures_.size();
  }

  public final ArrayList<Creature> getCreatures(){
       return  creatures_;
  }

  public boolean attraperCreature(final Creature creature){
       if(!creature.estAffaibli()){
           return false;
       }
       return ajouterCreature(creature);
  }

  public boolean ajouterCreature(final Creature creature){
       if(getCreature(creature.getNom()) == null){
           creatures_.add(creature);
           return  true;
       }
       return false;

  }

  public boolean supprimerCreature(final String nom){
       if (getCreature(nom) == null) {
            return false;
       }
       creatures_.remove(getCreature(nom));
       return true;
  }

  public final Creature getCreature(final String nom){
       for ( Creature creature : creatures_){
           if(creature.getNom().equals(nom)) {
               return creature;
           }
       }
       return null;
  }

  @Override
  public String toString() {
       String result = "[" + nom_ + "]\n\t";
       for( Creature creature: creatures_){
           result += creature + "\n";
       }
       return  result;
    }

  @Override
  public boolean equals(Object obj) {
       if (obj == this){
           return true;
       }

       if(!(obj instanceof  Dresseur)) {
           return false;
       }

       return ((Dresseur) obj).nom_.equals(nom_);
  }

  @Override
  public int hashCode() {
     return Objects.hashCode(nom_);
  }


}