package java8;

public class Program {

	public static void main(String[] args) {
		// functional interface - only 1 method
		Operation add = new Operation() {
			@Override
			public double calc(double num1, double num2) {
				return num1 + num2;
			}
		};
		System.out.println(add.calc(5, 3));
		
		// lambda
		// p1 -> { method }
		// (p1,p2) -> { method }
		// () -> { method }
		// () -> returnedValue
		Operation power = (n1 ,n2) -> Math.pow(n1, n2);
		System.out.println(power.calc(2, 13));
		
		OurPrinter printer = t -> System.out.println("Printer: " + t);
		printer.print("Nice");
		
		// not recommended - use a
		/*{
			n1 = n1*2;
			n2 = n2-10;
			return n1*n2;
		};*/
		Operation oper123 = (n1,n2) -> doit(n1, n2);
		System.out.println(oper123.calc(15, 22));
	}
	
	public static double doit(double n1, double n2) {
		n1 = n1*2;
		n2 = n2-10;
		return n1*n2;
	}

}
