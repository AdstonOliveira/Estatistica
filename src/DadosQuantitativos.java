
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * @author Adston Oliveira LinhaVerde Informatica
 */
public final class DadosQuantitativos {
   DecimalFormat df = new DecimalFormat("#.##");
   
   public DadosQuantitativos( ArrayList<Double> amostra ) {
      this.amostraOriginal = amostra;
      this.maior = getMaior(amostra,0);
      this.menor = getMenor(amostra,0);
   }
   
   private final ArrayList<Double> amostraOriginal;
   private final Double maior;
   private final Double menor;
   private ArrayList<String> intervalos;
   private ArrayList<Integer> qtdeIntervalos;
   private ArrayList<Double> percentIntervalos;
   private ArrayList<Double> proporcaoIntervalos;
   
   public ArrayList<String> getIntervalos() {
      return intervalos;
   }
   public ArrayList<Integer> getQtdeIntervalos() {
      return qtdeIntervalos;
   }
   
   
   public String toStringByInterval(){
      String retorno = "";
      
         for( String each : this.intervalos ){
            int i = 0;
            retorno += (each + ": " + this.qtdeIntervalos.get( i ) + "\n");
            i++;
         }
      return retorno;
      
   }
   
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

   public void getByInterval( ArrayList<Double> amostra, int qntdIntervalos ){
   Double range = ( maior - menor ) / qntdIntervalos;
   
      this.qtdeIntervalos = new ArrayList<>();
      this.intervalos = new ArrayList<>();
      
      if( qntdIntervalos <= ( maior - menor ) ){
        Double valueToAdd = menor;
            
             for( int i = 0; i < qntdIntervalos; i++ ){
                Double toAdd; 
                
                   if( i == qntdIntervalos-1){
                      toAdd = ( valueToAdd + (range) );
                   }else
                      toAdd = ( valueToAdd + (range-0.01) );

                this.intervalos.add( df.format(valueToAdd ) + " |--- " + df.format( toAdd ) ) ;
                this.qtdeIntervalos.add( contador( valueToAdd, toAdd ) );
                valueToAdd += (range);

         }
      }
      this.createPercent();
   }

   public int contador(Double inicio, Double fim){
      int conta = 0;
      
         for( int i = 0; i < amostraOriginal.size(); i++ ){
            Double compare = this.amostraOriginal.get( i );
            
               if( compare >= inicio && compare <= fim )
                  conta++;
         }
      return conta;
   }

   private void createPercent(){
      this.percentIntervalos = new ArrayList<>();
      
      for( int i = 0; i < this.intervalos.size(); i++ ){
         Double valor = Double.valueOf( this.qtdeIntervalos.get( i ) ) / this.amostraOriginal.size() * 100;
         this.percentIntervalos.add( valor );
      }
   }
   
   private void createProporcao(){
      this.proporcaoIntervalos = new ArrayList<>();
      
      for( int i = 0; i < this.intervalos.size(); i++ ){
         Double valor = Double.valueOf( this.qtdeIntervalos.get( i ) ) / this.amostraOriginal.size() ;
         this.proporcaoIntervalos.add( valor );
      }
   }
   
   public static void main( String[] args ) {
    ArrayList<Double> va = new ArrayList<>();
      va.add(9.4); va.add(5.4); va.add(5.1); va.add(5.3); va.add(5.2);
      va.add(.9);  va.add(5.4); va.add(5.4); va.add( 800.); va.add( 80.);
      va.add( 2.); va.add( 500.4);

      DadosQuantitativos dq = new DadosQuantitativos(va);
         //System.out.println(dq.getMaior(va, 0));
         //System.out.println(dq.getMenor(va, 0));

         dq.getByInterval ( va, 2 );
         //System.out.println( dq.contador( .9, 9.4, 0) ); //TESTE DO CONTADOR
         
      }
         
   
}



   

