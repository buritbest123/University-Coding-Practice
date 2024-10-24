package itcs209.labs.lab5;

public class ICTStudent {
    private String ID;
    private String givenName;
    private String ln;
    private int year;
    public ICTStudent(String ID,String givenName,String ln,int year)
    {
        this.ID = ID;
        this.givenName = givenName;
        this.ln = ln;
        this.year = year;
    }
    String getStudentID(){
        return this.ID;
    }
    String getFirstName(){
        return this.givenName;
    }
    String  getLastName(){
        return this.ln;
    }
    int getYear(){
        return this.year;
    }
    String getCapName(){
        String firstName = this.givenName.substring(0,1);
        String lastName = this.ln.substring(0,1);
        return firstName.toUpperCase()+ this.givenName.toLowerCase().substring(1)+" "+
                lastName.toUpperCase()+this.ln.toLowerCase().substring(1);
    }
    String getStudentInfoTSV(){
        return this.ID+"\t"+this.givenName+"\t"+this.ln+"\t"+this.year;
    }
    String getVowels(){
        String Student = "";
        String Check = this.givenName + this.ln;
    for(int i=0;i<Check.length();i++)
    {
        if(Check.charAt(i) == 'a'|| Check.charAt(i) == 'e'|| Check.charAt(i) == 'i'|| Check.charAt(i) == 'o'
                ||Check.charAt(i) == 'u'||Check.charAt(i) == 'A'||Check.charAt(i) == 'E'
                ||Check.charAt(i) == 'I'||Check.charAt(i) == 'O'||Check.charAt(i) == 'U')
        {
            Student+=Check.charAt(i);
        }
    }
    return Student;

    }
    String getShortID(){
        String shortID = this.ID.substring(ID.length() - 3);
        return shortID;
    }


}
