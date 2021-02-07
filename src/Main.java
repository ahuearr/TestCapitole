import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int previousPrint = 0;
		List<Integer> inList = new ArrayList<Integer>();
		for (int i = 0; i < args.length; i++) {
			try {
				inList.add(Integer.parseInt(args[i]));
			}catch(NumberFormatException ex) {
				inList.add(0);
			}
		}
		int maxElement = Collections.max(inList);
		//Recorremos el array sin necesidad de llegar al último elemento, que nunca va a tener un elemento mayor a la derecha
		for(int i = 0; i < inList.size() - 1; i++) {
			int pivotElement = inList.get(i);
			//Si el elemento es el mayor del array, el resultado es -1
			if(pivotElement == maxElement) {
				System.out.println(pivotElement + "  -->  -1");
				previousPrint = -1;
			/*Recorremos el array hacia la derecha buscando el primer mayor elemento si:
				a. Si el elemento no es el mayor del array
				   Y se cumplen alguna de las siguientes condiciones
				   1. Es el primer elemento
				   2. El elemento es mayor que el anterior elemento revisado
				   3. El elemento anterior era el máximo
				   4. El elemento es menor que el anterior elemento revisado y para ese anterior elemento no había un elemento mayor
			*/
			} else if((i == 0) || (pivotElement > inList.get(i-1)) || (inList.get(i-1) == maxElement) || (pivotElement < inList.get(i-1) && previousPrint == -1)) {
				/*Se recorre el array buscando un elemento mayor.
				 * Si se encuentra se escribe el máximo elemento y si se llega al final sin encontrarlo, el resultado es -1
				 */
				for(int j = i + 1; j < inList.size(); j++) {
					int element = inList.get(j);
					if(pivotElement < element) {
						System.out.println(pivotElement + "  -->  " + element);
						previousPrint = element;
						break;
					} else if (j == inList.size() - 1) {
						System.out.println(pivotElement + "  -->  -1");
						previousPrint = -1;
					}
				}
			//Si no se cumplen ninguna de las condiciones anteriores, no hace falta recorrer el array, el máximo elemento es el mismo que el encontrado para el elemento anterior
			} else {
				System.out.println(pivotElement + "  -->  " + previousPrint);
			}
		}
		//El último elemento siempre tiene de resultado -1
		System.out.println(inList.get(inList.size() - 1) + "  -->  -1");
	}
}
