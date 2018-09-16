package benchmark;

public class ClassUCProtosBuilders {

    public static ClassUCProtos.ClassUC buildClassUC(int numStudents){

        ClassUCProtos.ClassUC.Builder builder = ClassUCProtos.ClassUC.newBuilder();

        builder.setName("CLASSCLASS");
        builder.setDirector(buildPerson(0));

        for(int i = 0; i < numStudents; i++){
            builder.addStudents(buildPerson(i + 1));
        }

        return builder.build();
    }

    public static ClassUCProtos.Person buildPerson(int id){

        String number = String.valueOf(id);
        ClassUCProtos.Person.Builder person = ClassUCProtos.Person.newBuilder();
        String name = "", email = "";

        // Keep the 10 characters per String
        if(number.length() == 1){
            name = "ucucucucu" + number;
            email = number + "@ucucucuc";
        }else if(number.length() == 2){
            name = "ucucucuc" + number;
            email = number + "@ucucucu";
        }else if(number.length() == 3){
            email = number + "@ucucuc";
        }else if(number.length() == 4){
            name = "ucucucu" + number;
            email = number + "@ucucu";
        }else if(number.length() == 5){
            name = "ucucuc" + number;
            email = number + "@ucuc";
        }else{
            throw new RuntimeException("Too Large.");
        }

        person.setId(id).setName(name).setEmail(email).addContact(buildContact()).addContact(buildContact());
        return person.build();
    }

    public static ClassUCProtos.Person.Contact buildContact(){
        ClassUCProtos.Person.Contact contact = ClassUCProtos.Person.Contact.newBuilder().setNumber("+919191919").setType(ClassUCProtos.Person.TypeContact.HOME).build();
        return contact;
    }
}
