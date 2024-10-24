import java.util.ArrayList;

public class BinaryNameSearcher extends NameSearcher {
    public BinaryNameSearcher(String filename){
        super(filename);
    }
    public String BinarySearch(ArrayList<String> Arr,int left,int right,String query){
        if(right>=left){
            number_of_compared++;
            int mid = left+(right-left)/2;
            if(query.compareToIgnoreCase(Arr.get(mid))>0){
                return BinarySearch(Arr,mid+1,right,query);
            }
            if(query.compareToIgnoreCase(Arr.get(mid))<0){
                return BinarySearch(Arr,left,mid-1,query);
            }
            return "Found '"+ query + "' AT_INDEX("+ Arr.indexOf(query.toLowerCase()) +")";
        }
        else return "Not Found Name: '" + query + "'";
    }
    public String find(String query){
        sortName();
        return BinarySearch(readNames,0,readNames.size()-1,query);
    }
}
