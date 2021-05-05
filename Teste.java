class Main {
    public static void main(String[] args) {
        System.out.println("################# Teste CoresRGB #################");        
    
        System.out.println("__________________________________________________");
        System.out.println("Cor original");
        CoresRGB cor1 = new CoresRGB(37, 150, 190);
        System.out.println(cor1.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Cópia da cor original");
        CoresRGB corCopia = new CoresRGB(cor1);
        System.out.println(corCopia.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Segunda cópia da cor original");
        CoresRGB corCopia2 = new CoresRGB(cor1);
        System.out.println(corCopia2.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Cor preta");
        CoresRGB corPreta = new CoresRGB();
        System.out.println(corPreta.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Verificando se a cor cópia é igual à cor original");
        System.out.println(cor1.equals(corCopia));      
        
        System.out.println("__________________________________________________");
        System.out.println("Verificando se a cor preta é igual à cor original");
        System.out.println(cor1.equals(corPreta));  
        
        System.out.println("__________________________________________________");
        System.out.println("Clareando a cor cópia em 10%");
        corCopia.clarearTonalidade(0.1);
        System.out.println(corCopia.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Escurecendo a cor original em 10%");
        cor1.escurecerTonalidade(0.1);
        System.out.println(cor1.toString());
        System.out.println("");
        System.out.println("Cor preta escurecida");
        corPreta.escurecerTonalidade(0.1);
        System.out.println(corPreta.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Criando uma nova instância igual à cor original (já escurecida)");        
        CoresRGB cor2 = cor1.novaInstancia();
        System.out.println(cor2.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Teste para criar cor com componentes negativos");
        CoresRGB cor3 = new CoresRGB(-37, -150, -190);
        System.out.println(cor3.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Teste para criar cor com componentes maiores que 255");
        CoresRGB cor4 = new CoresRGB(256, 300, 350);
        System.out.println(cor4.toString());

        System.out.println("__________________________________________________");
        System.out.println("Criando uma cor PRETA");        
        CoresRGB corPRETA = CoresRGB.PRETA;
        System.out.println(corPRETA.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Criando uma cor BRANCA");        
        CoresRGB corBRANCA = CoresRGB.BRANCA;
        System.out.println(corBRANCA.toString());

        System.out.println("__________________________________________________");
        System.out.println("Criando uma cor RED");        
        CoresRGB corRED = CoresRGB.RED;
        System.out.println(corRED.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Criando uma cor GREEN");        
        CoresRGB corGREEN = CoresRGB.GREEN;
        System.out.println(corGREEN.toString());
        
        System.out.println("__________________________________________________");
        System.out.println("Criando uma cor BLUE");        
        CoresRGB corBLUE = CoresRGB.BLUE;
        System.out.println(corBLUE.toString());

        System.out.println("__________________________________________________");
        System.out.println("Criando uma cor em equivalente cinza");        
        CoresRGB corCinza = corCopia2.novaInstanciaCinza(corCopia2);
        System.out.println(corCinza.toString());
        
        System.out.println("#################### Fim teste ####################");        
        System.out.println(" ");
        System.out.println("################## Teste Imagem ###################");        

        System.out.println("__________________________________________________");
        System.out.println("Criando uma Imagem BRANCA");        
        Imagem imagem1 = new Imagem(5, 3);//new Imagem(altura, largura)
        System.out.println(imagem1.mostrarImagem());
        

        System.out.println("__________________________________________________");
        System.out.println("Modificando pixels da Imagem, dado o pixel");
        CoresRGB pixel1 = new CoresRGB(37, 150, 190);
        imagem1.modificarPixel(0, 0, pixel1);
        imagem1.modificarPixel(0, 1, pixel1);
        imagem1.modificarPixel(0, 2, pixel1);
        imagem1.modificarPixel(1, 0, pixel1);
        imagem1.modificarPixel(1, 1, pixel1);
        imagem1.modificarPixel(1, 2, pixel1);
        System.out.println(imagem1.mostrarImagem());
        
        System.out.println("__________________________________________________");
        System.out.println("Modificando pixels da Imagem, dados os valores RGB");
        imagem1.modificarPixel(2, 0, 37, 150, 190);
        imagem1.modificarPixel(2, 1, 37, 150, 190);
        imagem1.modificarPixel(2, 2, 37, 150, 190);
        imagem1.modificarPixel(3, 0, 37, 150, 190);
        imagem1.modificarPixel(3, 1, 37, 150, 190);
        imagem1.modificarPixel(3, 2, 37, 150, 190);
        System.out.println(imagem1.mostrarImagem());
        
        System.out.println("__________________________________________________");
        System.out.println("Comparando duas Imagens. Elas são iguais?"); 
        Imagem imagemA = new Imagem(5, 3);//new Imagem(altura, largura)
        Imagem imagemB = new Imagem(5, 3);//new Imagem(altura, largura)
        //imagemB.modificarPixel(3, 2, 100, 150, 200);
        System.out.println(imagemA.compararImagens(imagemB));
        
        System.out.println("__________________________________________________");
        System.out.println("Criando uma imagem em escala cinza");     
        
        System.out.println("Original");
        System.out.println(imagem1.toHexadecimal()); 
        System.out.println("");
        System.out.println("Cinza");
        Imagem imagemC = imagem1.equivalenteCinza();//imagem1
        System.out.println(imagemC.toHexadecimal());
        
        System.out.println("__________________________________________________");
        System.out.println("Verificando se uma imagem é fragmento de outra"); 
        Imagem imagemPrincipal = new Imagem(5, 5);//new Imagem(altura, largura)
        Imagem imagemFragmento = new Imagem(3, 3);//new Imagem(altura, largura)
        
        //Colorindo a imagem principal
        imagemPrincipal.modificarPixel(0, 0, 42, 155, 196);//0, 0, 37, 150, 191
        imagemPrincipal.modificarPixel(0, 1, 38, 151, 192);
        imagemPrincipal.modificarPixel(0, 2, 39, 152, 193);
        imagemPrincipal.modificarPixel(0, 3, 40, 153, 194);
        imagemPrincipal.modificarPixel(0, 4, 41, 154, 195);
        
        imagemPrincipal.modificarPixel(1, 0, 42, 155, 196);
        imagemPrincipal.modificarPixel(1, 1, 43, 156, 197);
        imagemPrincipal.modificarPixel(1, 2, 44, 157, 198);
        imagemPrincipal.modificarPixel(1, 3, 45, 158, 199);
        imagemPrincipal.modificarPixel(1, 4, 46, 159, 200);

        imagemPrincipal.modificarPixel(2, 0, 47, 160, 201);
        imagemPrincipal.modificarPixel(2, 1, 48, 161, 202);
        imagemPrincipal.modificarPixel(2, 2, 49, 162, 203);
        imagemPrincipal.modificarPixel(2, 3, 50, 163, 204);
        imagemPrincipal.modificarPixel(2, 4, 51, 164, 205);
        
        imagemPrincipal.modificarPixel(3, 0, 52, 165, 206);
        imagemPrincipal.modificarPixel(3, 1, 53, 166, 207);
        imagemPrincipal.modificarPixel(3, 2, 54, 167, 208);
        imagemPrincipal.modificarPixel(3, 3, 55, 168, 209);
        imagemPrincipal.modificarPixel(3, 4, 56, 169, 210);
        
        imagemPrincipal.modificarPixel(4, 0, 57, 170, 211);
        imagemPrincipal.modificarPixel(4, 1, 58, 171, 212);
        imagemPrincipal.modificarPixel(4, 2, 59, 172, 213);
        imagemPrincipal.modificarPixel(4, 3, 60, 173, 214);
        imagemPrincipal.modificarPixel(4, 4, 61, 174, 215);        
        
        //Colorindo a imgagem fragmento
        imagemFragmento.modificarPixel(0, 0, 42, 155, 196);
        imagemFragmento.modificarPixel(0, 1, 43, 156, 197);
        imagemFragmento.modificarPixel(0, 2, 44, 157, 198);

        imagemFragmento.modificarPixel(1, 0, 47, 160, 201);
        imagemFragmento.modificarPixel(1, 1, 48, 161, 202);
        imagemFragmento.modificarPixel(1, 2, 49, 162, 203);
        
        imagemFragmento.modificarPixel(2, 0, 52, 165, 206);
        imagemFragmento.modificarPixel(2, 1, 53, 166, 207);
        imagemFragmento.modificarPixel(2, 2, 54, 167, 208);
        
        System.out.println("Imagem principal");
        System.out.println(imagemPrincipal.toHexadecimal()); 
        System.out.println("");
        System.out.println("Imagem fragmento nº1");
        System.out.println(imagemFragmento.toHexadecimal());
        System.out.println("");
        System.out.println("É fragmento?");        
        System.out.println(imagemPrincipal.fragmentoImagens(imagemFragmento));
        System.out.println("");   
        
        Imagem imagemFragmento2 = new Imagem(3, 3);
        //Colorindo a imgagem fragmento2
        imagemFragmento2.modificarPixel(0, 0, 47, 160, 201);
        imagemFragmento2.modificarPixel(0, 1, 42, 155, 196);
        imagemFragmento2.modificarPixel(0, 2, 42, 155, 196);

        imagemFragmento2.modificarPixel(1, 0, 48, 161, 202);
        imagemFragmento2.modificarPixel(1, 1, 43, 156, 197);
        imagemFragmento2.modificarPixel(1, 2, 38, 151, 192);
        
        imagemFragmento2.modificarPixel(2, 0, 49, 162, 203);
        imagemFragmento2.modificarPixel(2, 1, 44, 157, 198);
        imagemFragmento2.modificarPixel(2, 2, 39, 152, 193);
        
        System.out.println("Imagem principal");
        System.out.println(imagemPrincipal.toHexadecimal()); 
        System.out.println("");
        System.out.println("Imagem fragmento nº2");
        System.out.println(imagemFragmento2.toHexadecimal());
        System.out.println("");
        System.out.println("É fragmento?");        
        System.out.println(imagemPrincipal.fragmentoImagens(imagemFragmento2));
        System.out.println("");
        
        System.out.println("");
        System.out.println("Teste dupla rotação"); 
        
        System.out.println("");
        System.out.println("Imagem principal duplamente rotacionada"); 
        Imagem imagemDupRot = imagemPrincipal.rotacionar();
        imagemDupRot = imagemDupRot.rotacionar();
        System.out.println(imagemDupRot.toHexadecimal());
        
        System.out.println("");        
        System.out.println("Imagem fragmento nº1");
        System.out.println(imagemFragmento.toHexadecimal());
        System.out.println("");
        
        System.out.println("É fragmento?");        
        System.out.println(imagemPrincipal.fragmentoImagens(imagemFragmento));
        System.out.println("");
    }
}

