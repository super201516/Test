package simpleCRUD;

import com.test.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class GetEmployee extends UserServiceHelper{
	public static void getempwithid() {
		Response Getres = getEmployeewithid();
		ResponsePrint(Getres);
		verifystatuscode(Getres,200);
		validate_equal(Getres,"status","success");
		validatecontentType(Getres,"application/json");
		validate_equal(Getres,"data.employee_name","Garrett Winters");
		validate_equal(Getres,"data.employee_salary","170750");
		//validate_equalInteger(Getres,"data.employee_salary","170750");
		validate_equal(Getres,"data.employee_age","63");
	}

}
