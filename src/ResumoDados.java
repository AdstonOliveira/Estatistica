
import java.util.ArrayList;
/**
 *
 * @author Adston Oliveira LinhaVerde Informatica
 */
public class ResumoDados {
   
   public static void main( String[] args ) {

      ArrayList<String> quali = new ArrayList<String>();
         
         for(int i = 0; i < 10; i++ ){
               if( i < 3 )
                  quali.add("Adston");
      
               if(i > 2 && i < 7)
                  quali.add("Teste");
               
               if(i >= 7)
                  quali.add("Teste2");
         }     
         
         DadosQualitativos dq = new DadosQualitativos(quali);
        
         System.out.println("Nome   |Frequencia | Proporção | Percentagem");
            int totalOcorrencia = 0;
            Double totalProporcao = 0.;
            int totalPercent = 0;
            
         for( int i = 0; i < dq.identificador.size(); i++ ) {
            System.out.println(dq.identificador.get(i) + "          " + dq.ocorrencia.get(i) + "          " + dq.proporcao.get(i) + 
                    "          " + dq.percentagem.get(i)+ "%" );
            
            totalOcorrencia += dq.ocorrencia.get(i);
            totalProporcao += dq.proporcao.get(i);
            totalPercent += dq.percentagem.get(i);
      }
         System.out.println("Totais:        " + totalOcorrencia + "       " + totalProporcao + "       " + totalPercent + "%");
         
         
         
         
   }
}
                 
                 
                 
                 
         

      
   
   
   

