import com.digdes.school.JavaSchoolStarter;
import com.digdes.school.services.Parser;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        JavaSchoolStarter starter = new JavaSchoolStarter();


        try {

            List<Map<String, Object>> result71 = starter.execute("SELECT");
            List<Map<String, Object>> result1 = starter.execute("INSERT VALUES 'lastName' = 'Ivanov', 'id' = '1', 'age' = '40', 'active' = false , 'cost' = 15'");
            List<Map<String, Object>> result2 = starter.execute("INSERT VALUES 'lastName' = 'Sidorov', 'id' = '2', 'age' = '10', 'active' = true , 'cost' = 9' ");
            List<Map<String, Object>> result3 = starter.execute("INSERT VALUES 'lastName' = 'Petrov', 'id' = '3', 'age' = '20', 'active' = true , 'cost' = 4'");
            List<Map<String, Object>> result223 = starter.execute("DELETE  where 'lastName' = 'Petrov'");
            List<Map<String, Object>> result711 = starter.execute("SELECT");


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}