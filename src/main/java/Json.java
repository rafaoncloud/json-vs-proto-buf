import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Entities.ClassUC;

public class Json {

    public static  void run(ClassUC classUC)
    {
        System.out.println("Class Name: " + classUC.getName());
        long startTime = System.nanoTime();
        String jsonRepresentation = buildJSON(classUC);

        //ClassUC test = buildClassUCfromJSON(jsonRepresentation);
        //System.out.println(jsonRepresentation);
        //printPrettyJSON(test);

        //classUc

        JsonFile.write(jsonRepresentation);
        ClassUC classUCread = JsonFile.read();
        // Print to test the result
        System.out.println("Duration " + (System.nanoTime() - startTime) + " milliseconds");
        printPrettyJSON(classUCread);

    }

    public static String buildJSON(ClassUC classUC){

        Gson json = new Gson();
        String jsonRepresentation = json.toJson(classUC);

        return jsonRepresentation;

    }

    public static ClassUC buildClassUCfromJSON(String JSON){

        Gson gson = new Gson();
        ClassUC classUC = gson.fromJson(JSON, ClassUC.class);
        return classUC;
    }

    public static void printPrettyJSON(String jsonRepresentation){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toPrint = gson.toJson(jsonRepresentation);
        System.out.println(toPrint);
    }

    public static void printPrettyJSON(ClassUC classUC){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toPrint = gson.toJson(classUC);
        System.out.println(toPrint);
    }

    public static void receiveJSON(){

    }

}
