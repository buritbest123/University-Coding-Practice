public class LinearNameSearcher extends NameSearcher {

    public LinearNameSearcher (String filename){
        super(filename);
    } 
    @Override
    public String find(String query){
        for(int i = 0 ; i< readNames.size();i++){
            number_of_compared++;
            if(query.compareToIgnoreCase(readNames.get(i))==0){
                return "Found '"+ query+ "' AT_INDEX("+i+")";
            }
        }
        return "Not Found Name: '" + query + "'";
    }
}
