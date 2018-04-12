
import java.util.ArrayList;

/**
 *
 * @author Adston Oliveira LinhaVerde Informatica
 */
public final class DadosQuantitativos {

   public DadosQuantitativos(ArrayList<Double> amostra) {

      maior = getMaior(amostra,0);
      menor = getMenor(amostra,0);
      
   }
   
   Double maior;
   Double menor;

public Double getMaior(ArrayList<Double> amostra, int valor){
   if( !amostra.isEmpty() ){
      if( valor < amostra.size() ){
         
         if( amostra.get(valor) >= getMaior(amostra,valor+1) )
            return amostra.get(valor);
         else
            return getMaior(amostra,valor+1);
      }
   }
      return .0;
}

public Double getMenor(ArrayList<Double> amostra, int valor){
   if( !amostra.isEmpty() ){
      if( valor < amostra.size() ){
         
         if( amostra.get( valor ) < getMenor( amostra, valor+1 ) )
            return amostra.get(valor);
         else
            return getMenor( amostra, valor+1 );
      }
   }
      return getMaior(amostra,0);
}

public void getByInterval(ArrayList<Double> amostra, int interval){
   Double maxInterval = ( maior - menor );
      ArrayList<Integer> qtde = new ArrayList<>();
      ArrayList<String> intervalos = new ArrayList<>();
      
      if( interval <= maxInterval ){
         
        
         for( int i = 0; i < 10; i++) {
            
         }
         
         
         
         
         
      }
   
}


   public static void main( String[] args ) {
    ArrayList<Double> va = new ArrayList<>();
      va.add(9.4);      va.add(5.4);      va.add(5.1);      va.add(5.3);      va.add(5.2);
      va.add(.9);      va.add(5.4);      va.add(5.4);

      DadosQuantitativos dq = new DadosQuantitativos(va);
         System.out.println(dq.getMaior(va, 0));
         System.out.println(dq.getMenor(va, 0));
      
   }



   
}
