package javaclase.con.kevinolarte.ejr.tema07_2;

public class AnalizadorWeb {
    private final Pila pila;
    private final String texto;

    public AnalizadorWeb(Pila pila, String texto){
        this.texto = texto;
        this.pila = pila;
    }

    public boolean analizar(){
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '<') {
                //System.out.println("entrar");
                boolean atributo = false;
                boolean comentario = false;
                for (int j = i; j < texto.length(); j++) {
                    stb.append(texto.charAt(j));
                    
                    if (stb.toString().contains("<!--")){
                        comentario = true;
                    }

                    if (texto.charAt(j) == '>' && stb.toString().contains("-->")){
                        comentario = false;
                    }
                     
                    if ((texto.charAt(j) == '"' || texto.charAt(j) == '\'') && !comentario)  
                    {
                        atributo = !atributo;
                    }
                    
                    
                    if (texto.charAt(j) == '>' && !atributo && !comentario){
                        //System.out.println(stb.toString() + "-----------");
                        i = j;
                        break;
                    }   
                    else if(j == texto.length() -1 && comentario){
                        return false;
                    }
                }
                String comparar = eliminarAtributos(stb.toString()).toLowerCase();
                stb.setLength(0);

                if (comparar.length() <= 2) {
                    return false;

                }
                else if(comparar.contains("!doctype") || (comparar.contains("<!--") && comparar.contains("-->")))
                   continue; 
                else if (comparar.charAt(1) == '/') {
                    String aux = pila.pop();
                    if(aux == null) 
                        return false;
                        
                    comparar = comparar.substring(2, comparar.length() -1);
                    if (!comparar.equals(aux))
                        return false;
                        
                }
                else if (comparar.charAt(comparar.length() -2) != '/'){
                    comparar = comparar.substring(1, comparar.length() -1).toLowerCase();
                    pila.push(comparar);
                }
                

                
            }
            

                

        }
        return pila.isEmpty();
    }

    /**
     * Metodo para devilver una etiqueta sin espacios y sun Atributos
     * @param etiquetaHTML
     * @return
     */
    private static String eliminarAtributos(String etiquetaHtml) {
       
        //Buscamos los atributos
        String etiquetaSinAtributos = etiquetaHtml.replaceAll("\\s+([a-zA-Z][a-zA-Z0-9_-]*)\\s*=\\s*\"[^\"]*\"", "");
        //etiquetaSinAtributos = etiquetaSinAtributos.replaceAll("\\s+", "");
        return etiquetaSinAtributos;
    }
}
