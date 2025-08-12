namespace PSS.jgb347.Practica_03
{
    public class Ficha
    {
        // Primero se crean los atributos de la clase ficha, que serán color y forma, cada atributo tiene su propio tipo de variable, que más adelante está explicado el por qué
        private ColorEnum color;
        private FormaEnum forma;


        // Tras crear los atributos, están los diferentes constructores para crear objetos de tipo ficha.
        public Ficha()
        {
            color = ColorEnum.SinColor;
            forma = FormaEnum.SinForma;
        }

       
        public Ficha(ColorEnum color, FormaEnum forma)
        {
            this.color = color;
            this.forma = forma;
        }

      
        public Ficha(ColorEnum color)
        {
            this.color = color;
            forma = FormaEnum.SinForma; 
        }

        
        //Una vez que están los constructores se hacen los getter y setters.
        public ColorEnum Color
        {
            get { return color; }
            set { color = value; }
        }

       
        public FormaEnum Forma
        {
            get { return forma; }
            set { forma = value; }
        }
    }

    
    //Y a continuación las posibles opciones de colores y formas, en el caso de querer de más tipos, es tan fácil como añadir más colores o formas.
    public enum ColorEnum
    {
        SinColor,
        Blanco,   
        Negro     
    }


    public enum FormaEnum
    {
        SinForma, 
        Redonda,  
        Cuadrada  
    }
}


