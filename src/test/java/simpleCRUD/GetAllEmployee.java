package simpleCRUD;

import com.test.helpers.UserServiceHelper;
import com.test.models.GetEmployeerootPOJO;
import io.restassured.response.Response;

public class GetAllEmployee extends UserServiceHelper {
	public static void getEmployees() {
		
		Response res = getemployee();
		GetEmployeerootPOJO emplist = res.as(GetEmployeerootPOJO.class);
		System.out.println(emplist);
		getStatusCode(res);
		verifystatuscode(res,200);
		validate_equal(res,"status","success");
		String size = GetDataFromResponse(res,"data.size()");
		System.out.println("No of datas :"+size);

		
	}
}
