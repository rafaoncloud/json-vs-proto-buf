import Entities.ClassUC;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Xml
{
    public static  void run(ClassUC classUC)
    {
        System.out.println("Class Name: " + classUC.getName());
        long startTime = System.nanoTime();

        String xml = serialize(classUC);

        System.out.println(xml);


        System.out.println("Duration " + (System.nanoTime() - startTime) + " milliseconds");

    }
    private static String serialize(ClassUC classUc)
    {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(ClassUC.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            StringWriter sw = new StringWriter();
            m.marshal(classUc, sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return xmlString;
    }
}
