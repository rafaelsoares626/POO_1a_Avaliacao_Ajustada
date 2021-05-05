public class Imagem
{
    //i. a representação estática da classe criada
    private CoresRGB[][] pixel;
    //ii. um construtor que crie uma Imagem. O tamanho da Imagem será passado como parâmetro no construtor. A imagem criada deve ter todos os píxels ajustados para o BRANCO
    public Imagem(int altura, int largura){
        this.pixel = new CoresRGB[altura][largura];
        int i, j;
        for(i = 0; i < altura; i++){
            for(j = 0; j < largura; j++){
                this.pixel[i][j] = CoresRGB.BRANCA;
            }
        }
    }
    //iii. um método que modifique o pixel de uma imagem dada a posição e o pixel
    public void modificarPixel(int linha, int coluna, CoresRGB pixel){
        this.pixel[linha][coluna] = pixel;
    }
    //iv. sobrecarregue este método para modifique o pixel de uma imagem dada a posição e os valores de RGB do pixel.
    public void modificarPixel(int linha, int coluna, int red, int green, int blue){
        CoresRGB pixel2 = new CoresRGB(red, green, blue);
        this.pixel[linha][coluna] = pixel2;     
    }
    //v. método que verifique que duas imagens são iguais
    public boolean compararImagens(Imagem imagem){
        //Verificando se as dimensões das figuras são idênticas.
        int tamanho = 0;
        if((this.pixel.length == imagem.pixel.length) && (this.pixel[0].length == imagem.pixel[0].length)){
            tamanho = 1;
        }else{
            return false;
        }
        //Comparando cada pixel das imagens informadas pelo usuário.
        int i, j;
        int area = this.pixel.length * this.pixel[0].length;        
        int areaCalculada = 0;        
        for(i = 0; i < this.pixel.length; i++){
            for(j = 0; j < this.pixel[0].length; j++){
                if(imagem.pixel[i][j].equals(this.pixel[i][j])){
                    areaCalculada = areaCalculada + 1;
                }
            }          
        }
        if(area == areaCalculada && tamanho == 1){
            return true;
        }else{
            return false;
        }        
    }
    //vi. método que crie uma nova imagem com o equivalente em tons de cinza. Essa imagem deve ter os valores de cada pixel da cor original substituido pelo seu equivalente em cor de cinza.
    public Imagem equivalenteCinza(){//Imagem imagem
        Imagem imagemCinza = new Imagem(this.pixel.length, this.pixel[0].length);
        int i, j;
        for(i = 0; i < this.pixel.length; i++){
            for(j = 0; j < this.pixel[0].length; j++){
                imagemCinza.pixel[i][j] = this.pixel[i][j].novaInstanciaCinza(this.pixel[i][j]);
            }
        }
        return imagemCinza;
    }
    //vii. método que verifique se uma imagem é um fragmento da outra
    public boolean fragmentoImagens(Imagem imagem){
        //Imagem fragmento não rotacionada
        //Altura vs Altura / Largura vs Largura
        int tamanhoSemGiro = 0, tamanhoComGiro = 0;        
        if((this.pixel.length >= imagem.pixel.length) && (this.pixel[0].length >= imagem.pixel[0].length)){
            tamanhoSemGiro = 1;//Dimensões compatíveis
        }else{
            tamanhoSemGiro = 0;//Dimensões incompatíveis
        }
        //Imagem fragmento rotacionada
        //Altura vs Largura
        if((this.pixel.length >= imagem.pixel[0].length) && (this.pixel[0].length >= imagem.pixel.length)){
            tamanhoComGiro = 1;//Dimensões rotacionadas compatíveis
        }else{
            tamanhoComGiro = 0;//Dimensões rotacionadas incompatíveis
        }
        //Comparando cada pixel das imagens informadas pelo usuário.
        int i, j, l, c, rodar, rotacionar180Graus = 0;
        int area = imagem.pixel.length * imagem.pixel[0].length;//Area do fragmento    
        int areaCalculada = 0;//Variável incrementadora
        int alturaPrincipal = this.pixel.length - imagem.pixel.length + 1;
        int larguraPrincipal = this.pixel[0].length - imagem.pixel[0].length + 1;
        if(tamanhoSemGiro == 1 || tamanhoComGiro == 1){
            //Cada for representa uma rotação de 90 ou 180º
            for(rodar = 0; rodar < 4; rodar++){
                if(rotacionar180Graus > 1){
                    //Se der uma rotacionada 180º por mais de uma vez, as imagens são incompatíveis
                    return false;
                }
                if(tamanhoSemGiro == 0 && tamanhoComGiro == 1){
                    //Dimensões só são compatíveis se rotacionar
                    imagem = imagem.rotacionar();//imagem
                }
                //Percorrendo a imagem principal (procurando o primeiro pixel idêntico)
                for(l = 0; l < alturaPrincipal; l++){
                    for(c = 0; c < larguraPrincipal; c++){ 
                        if(this.pixel[l][c].equals(imagem.pixel[0][0])){
                            //Percorrendo a imagem fragmento
                            for(i = 0; i < imagem.pixel.length; i++){
                                for(j = 0; j < imagem.pixel[0].length; j++){
                                    if(imagem.pixel[i][j].equals(this.pixel[i + l][j + c])){
                                        //Incrementando a cada pixel idêntico
                                        areaCalculada = areaCalculada + 1;
                                        if(areaCalculada == area){
                                            return true;
                                        }
                                    }
                                }
                            }
                            areaCalculada = 0;//Zerando o contador, para o caso de não ter sido identificada a figura. 
                        }
                    }            
                }
                if(tamanhoSemGiro == 1 && tamanhoComGiro == 1){
                    //Dimensões são compatíveis rotacionando ou não
                    imagem = imagem.rotacionar();//imagem
                }else if(tamanhoSemGiro == 1 && tamanhoComGiro == 0){
                    //Dimensões só são compatíveis se não rotacionar
                    imagem = imagem.rotacionar();//imagem
                    imagem = imagem.rotacionar();//imagem
                    rotacionar180Graus = rotacionar180Graus + 1;
                }else if(tamanhoSemGiro == 0 && tamanhoComGiro == 1){
                    //Dimensões só são compatíveis se rotacionar
                    imagem = imagem.rotacionar();//imagem
                    imagem = imagem.rotacionar();//imagem
                    rotacionar180Graus = rotacionar180Graus + 1;
                }            
            }
        }
        return false;
    }
    //Rotacionar imagem
    public Imagem rotacionar(){//Imagem imagem
        Imagem imagemRotacionada = new Imagem(this.pixel[0].length, this.pixel.length);
        int i, j, cont = 0;
        for(i = 0; i < imagemRotacionada.pixel.length; i++){
            for(j = 0; j < imagemRotacionada.pixel[0].length; j++){
                imagemRotacionada.pixel[i][j] = this.pixel[j][this.pixel[0].length - i - 1];
            }
        }        
        return imagemRotacionada;
    }   
    //Mostrar a imagem    
    public String mostrarImagem() {
        String s = "";
        for(int k = 0; k < this.pixel.length; k++)
        {
            for(int w = 0; w < this.pixel[k].length; w++)
            {
                if(w == 0){
                    s = s + "\n" + this.pixel[k][w].getLuminosidade();
                }else{
                    s = s + this.pixel[k][w].getLuminosidade();
                }
            }
        }
        return s;
    }
    //Mostrar a imagem em hexadecimal
    public String toHexadecimal() {
        String s = "";
        for(int k = 0; k < this.pixel.length; k++)
        {
            for(int w = 0; w < this.pixel[k].length; w++)
            {
                if(w == 0){
                    s = s + "\n" + this.pixel[k][w].hexadecimal();
                }else{
                    s = s + this.pixel[k][w].hexadecimal();
                }
            }
        }
        return s;
    }
}
