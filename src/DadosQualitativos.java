
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Adston Oliveira LinhaVerde Informatica
 */
public final class DadosQualitativos {
   
   public DadosQualitativos(ArrayList<String> dados) {
      this.getOcorrencias(dados);
   }
   Integer qntdeDados;
   
   ArrayList<String> identificador = new ArrayList<>();
   ArrayList<Integer> ocorrencia = new ArrayList<>();
   ArrayList<Double> percentagem = new ArrayList<>();
   ArrayList<Double> proporcao = new ArrayList<>();
   
   ArrayList<String> idInterval;
   ArrayList<Integer> byInterval;
   
   static boolean existe(ArrayList<String> array, String valor){
      /** Retorna se o valor passado existe no array */
         if( array != null ){
         
            for(String each : array){
                  if( each.equals(valor) )
                     return true;
               }
            }
   
         return false;
   }
   
   public void getOcorrencias(ArrayList<String> array){
      /**Verifica qual a quantidade de cada elemento diferente no array*/
      ArrayList<String> tempId = new ArrayList<>();
      ArrayList<Integer> qtdade = new ArrayList<>();
      this.qntdeDados = array.size();
      
         for( String each : array ){
         int qtde = 0;
            /** Conta qtos elementos iguais existem */
            for( int j = 0; j < array.size(); j++ ){
               if( each.equals( array.get(j) ) )
                  qtde ++;
            }
            /** Se for vazio adiciona a primeira posição */
               if( tempId.isEmpty() ){
                  tempId.add(each);
                  qtdade.add(qtde);
               } else {
                  /* Se existe eleemnto, compara no array Temp*/
                  if( !existe( tempId,each ) ){
                     tempId.add(each);
                     qtdade.add(qtde);
                  }
               }
         }
         
      for( int i = 0; i < tempId.size(); i++ ){
         System.out.println(tempId.get(i) + " :");
         System.out.println(qtdade.get(i));
      }
      
      this.create(tempId,qtdade);
   }
   
   public void create(ArrayList<String> identificador, ArrayList<Integer> qtde){
      if( identificador != null && qtde != null){
         this.identificador = identificador;
         this.ocorrencia = qtde;
         
         createPercent();
         createProporcao();
      }
   }

   void createPercent(){
      if( this.qntdeDados > 0 ){
         int a = qntdeDados;

         for( int i = 0; i < this.ocorrencia.size(); i++ ){
            Double q = Double.valueOf( ocorrencia.get(i) );
            percentagem.add( q/a *100);
         }
      }
   }

   void createProporcao(){
      if( this.qntdeDados > 0 ){
         int a = qntdeDados;

         for( int i = 0; i < this.ocorrencia.size(); i++ ){
            Double q = Double.valueOf( this.ocorrencia.get(i) );
            this.proporcao.add( q/a );
         }
         
      }
   }
   
   void getByValue(int byValue, int interval){
  
      
      
   }
   
   
  
   
   
   
}
