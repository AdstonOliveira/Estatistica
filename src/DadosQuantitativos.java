import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * @author Adston Oliveira LinhaVerde Informatica
 */
public final class DadosQuantitativos {
   DecimalFormat df = new DecimalFormat("#.##");
   
   public DadosQuantitativos( ArrayList<Double> amostra, int intervalo ) {
      this.amostraOriginal = amostra;
      this.maior = getMaior(amostra,0);
      this.menor = getMenor(amostra,0);
         
      this.getByInterval( amostra, intervalo );
   }
   
   private final ArrayList<Double> amostraOriginal;
   private final Double maior;
   private final Double menor;
   private ArrayList<String> intervalos;
   private ArrayList<Integer> qtdeIntervalos;
   private ArrayList<Double> percentIntervalos;
   private ArrayList<Double> proporcaoIntervalos;
   
   public boolean isEmpty(){
      return amostraOriginal == null;
   }

   public ArrayList<Double> getPercentIntervalos() {
      return percentIntervalos;
   }

   public ArrayList<Double> getProporcaoIntervalos() {
      return proporcaoIntervalos;
   }
   
   public void getByPorcion(int porcao){
      
      
      
      
   }
   
   
   
   
   public ArrayList<String> getIntervalos() {
      if( !this.isEmpty() )
         return intervalos;
      
      return null;
   }
   
   public ArrayList<Integer> getQtdeIntervalos() {
      if( !this.isEmpty() )
         return qtdeIntervalos;
      return null;
   }
   
   public String toStringByInterval(){
      if( !this.isEmpty() ){
      String retorno = "";
      
         for( String each : this.intervalos ){
            int i = 0;
            retorno += (each + ": " + this.qtdeIntervalos.get( i ) + "\n");
            i++;
         }
      return retorno;
      }
      
    return null;
   }
   
   public Double getMaior( ArrayList<Double> amostra, int valor ){
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

   public Double getMenor( ArrayList<Double> amostra, int valor ){
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
   if( !this.isEmpty() ){      

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
      this.createProporcao();
   }
   }

   public int contador( Double inicio, Double fim ){
   if( !this.isEmpty() ){ 
      int conta = 0;
      
         for( int i = 0; i < amostraOriginal.size(); i++ ){
            Double compare = this.amostraOriginal.get( i );
            
               if( compare >= inicio && compare <= fim )
                  conta++;
         }
      return conta; 
   }
   return 0;
   }

   private void createPercent(){
      if( !this.isEmpty() ){ 
      this.percentIntervalos = new ArrayList<>();
      
      for( int i = 0; i < this.intervalos.size(); i++ ){
         Double valor = Double.valueOf( this.qtdeIntervalos.get( i ) ) / this.amostraOriginal.size() * 100;
         this.percentIntervalos.add( valor );
      }
      }
   }
   
   private void createProporcao(){
      if( !this.isEmpty() ){ 
      this.proporcaoIntervalos = new ArrayList<>();
      
      for( int i = 0; i < this.intervalos.size(); i++ ){
         Double valor = Double.valueOf( this.qtdeIntervalos.get( i ) ) / this.amostraOriginal.size() ;
         this.proporcaoIntervalos.add( valor );
      }
      }
   }
   
}
