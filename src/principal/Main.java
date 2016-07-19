package principal;

public class Main {
	public static void main(String[] args) {
		Model model = new Model();
		
		/*Object s = "12";
		System.out.println(model.toInt(s));*/
		
		View view = new View(model);
		view.setVisible(true);
		
		/*Object[] obj = {0,1,1,"doña","marta", 234, "cerro 22", 32, 1};
		model.insert_cliente(obj);*/
		
		//probar Probar = new probar();
		
	}
}
