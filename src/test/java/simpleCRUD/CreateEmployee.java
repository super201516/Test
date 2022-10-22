package simpleCRUD;

import java.io.IOException;
import com.test.models.*;
import com.test.helpers.UserServiceHelper;
import com.test.models.CreateEmp1POJO;

import io.restassured.response.Response;

public class CreateEmployee extends UserServiceHelper {
	public static void AddEmployee() {
		System.out.println("add employee");
		Response res = createemployee();
		CreateEmp1POJO CreList = res.as(CreateEmp1POJO.class);
		System.out.println(CreList);
		ResponsePrint(res);
		getStatusCode(res);
		verifystatuscode(res,200);
		validate_equal(res,"status","success");
		String name = GetDataFromResponse(res,"data.employee_name");
		String age = GetDataFromResponse(res,"data.employee_age");
		String salary = GetDataFromResponse(res,"data.employee_salary");
		String id = GetDataFromResponse(res,"data.id");
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("salary:"+salary);
		System.out.println("id:"+id);
        validate_equal(res,"data.employee_name","test");
		validate_equal(res,"data.employee_salary","123");
		validate_equal(res,"data.employee_age","23");
		try {
			writeProperty(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
