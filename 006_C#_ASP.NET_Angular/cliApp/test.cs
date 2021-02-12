namespace cliApp
{
    public class Test
    {
        private int a {get; set;}
        private int b {get; set;}
        private int c {get; set;}

        public Test(int a, int b)
        {
            this.a = a;
            this.b = b;
            this.c = a + b;
        }

    
        public override string ToString(){
            return ( this.c.ToString() + "\n" + this.b.ToString() + "\n" + this.a.ToString() + "\n" );
        }
    }
}