import java.util.LinkedList;

public class Problemalivello1 {


    double []required;  // Contiene il totale delle richieste di ciasquna destinazione.(D)
    double []stock;     // Contiene il totale delle produzioni di ciasquna unita produtiva.(U.P.)
    double [][]cost;    // Contiene i costi di trasporto per spostare un'unità del bene da U.P.x alla D.y
    int stockSize;  // Il numero di unita produttive.
    int requiredSize;   //Il numero di destinazioni.
    LinkedList<Transportation> solution = new LinkedList<Transportation>(); // Una lista che contiene tutti i dati relativi ai spostamenti.

    public Problemalivello1(int stockSize, int requiredSize ){
        this.stockSize = stockSize;
        this.requiredSize = requiredSize;

        stock = new double[stockSize];
        required = new double[requiredSize];
        cost = new double[stockSize][requiredSize];

        for(int i=0; i < (requiredSize + stockSize -1); i++)
            solution.add(new Transportation());

    }

    public void setStock(double value, int index){
        stock[index] = value;
    }

    public void setRequired(double value, int index){
        required[index] = value;
    }


    public void setCost(double value, int stockPos, int requiredPos){
        cost[stockPos][requiredPos] = value;
    }

    public void northWestCorner() {
        double min;
        int k = 0; //Il counter delle soluzioni

        //isSet annota le celle che sono state allocate
        boolean [][]isSet = new boolean[stockSize][requiredSize];
        for (int j = 0; j < requiredSize; j++)
            for (int i = 0;  i < stockSize; i++)
                isSet[i][j] = false;

        //Il for loop itera nella modalità "nord-ovest"
        for (int j = 0; j < requiredSize; j++)
            for (int i = 0;  i < stockSize; i++)
                if(!isSet[i][j]){

                    //allocating stock in the proper manner
                    min = Math.min(required[j], stock[i]);

                    solution.get(k).setRequired(j);
                    solution.get(k).setStock(i);
                    solution.get(k).setValue(min);
                    k++;

                    required[j] -= min;
                    stock[i] -= min;

                    //alloca valori nulli nelle collone e righe rimosse
                    if(stock[i] == 0)
                        for(int l = 0; l < requiredSize; l++)
                            isSet[i][l] = true;
                    else
                        for(int l = 0; l < stockSize; l++)
                            isSet[l][j] = true;
                }
    }

    public double getSolution(){
        double result = 0;
        for(Transportation a: solution){
            result += a.getValue() * cost[a.getStock()][a.getRequired()];
            System.out.println("Costo: " + (a.getValue() * cost[a.getStock()][a.getRequired()]) );
        }

        return result;

    }}
