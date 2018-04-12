/**
 * @author Adston Oliveira LinhaVerde Informatica
 */
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graficos {

    public static void main(String[] args) {
       
       ArrayList<Double> toAnalyse = new ArrayList<>();
       toAnalyse.add(1.); toAnalyse.add(10.); toAnalyse.add(100.); toAnalyse.add(2.); toAnalyse.add(21.); toAnalyse.add(221.);
       toAnalyse.add(31.); toAnalyse.add(331.); toAnalyse.add(41.); toAnalyse.add(1.4);
       
       DadosQuantitativos dq = new DadosQuantitativos(toAnalyse, 5);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for( int i = 0; i < dq.getIntervalos().size(); i++ )
           dataset.addValue(  dq.getQtdeIntervalos().get( i ) , "Faixas", dq.getIntervalos().get( i ) );
/*        dataset.addValue(27, "Temperatura", "12:00");
        dataset.addValue(35, "Temperatura", "14:00");
        dataset.addValue(52, "Temperatura", "16:00");
        dataset.addValue(13, "Temperatura", "18:00");

        JFreeChart graficoLinhas = ChartFactory.createLineChart("Título do Meu Grafico", "Dia 10/04/2018", "Graus Celsius", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        JFrame frame1 = new JFrame("Janela do Gráfico de Linhas");
        frame1.add(new ChartPanel(graficoLinhas));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocation(0, 10);
        frame1.setVisible(true);
*/        
        
        
        JFreeChart graficoBarras = ChartFactory.createBarChart("Título do Meu Grafico", "Dia 10/04/2018", "Graus Celsius", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        JFrame frame2 = new JFrame("Janela do Gráfico de Barras");
        frame2.add(new ChartPanel(graficoBarras));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setLocation(700, 10);
        frame2.setVisible(true);  
        
        
        
        // AS LINHAS ABAIXO SERVEM EXCLUSIVAMENTE PARA SALVAR O GRÁFICO EM UM ARQUIVO PNG
        /* try{
           System.out.println("Criando Gráfico...");
        OutputStream arquivo = new FileOutputStream("graficoLinhas.png");
        ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        arquivo.close();
       }catch(IOException io){ 
           System.out.println("Erro de IO "+io.getMessage()); 
       }
        System.out.println("Gráfico Criado !");
         */
        
        
        

    }

}