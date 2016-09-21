package exportar;

public class ExportarEstrategia {
	
	   //use getShape method to get object of type shape 
	   public Exportar getFormato(String tipoFormato, String ruta){
	      if(tipoFormato == null){
	         return null;
	      }		
	      if(tipoFormato.equalsIgnoreCase("HTML")){
	          return new ExportarHtml();
	         
	      } else if(tipoFormato.equalsIgnoreCase("XML")){
	         return new ExportarXml();
	         
	      } else if(tipoFormato.equalsIgnoreCase("PDF")){
	         return new ExportarPdf(ruta);
	      }
	      
	      return null;
	   }
}
