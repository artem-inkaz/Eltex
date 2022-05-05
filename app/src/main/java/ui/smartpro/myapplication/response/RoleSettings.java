package ui.smartpro.myapplication.response;

import com.google.gson.annotations.SerializedName;

public class RoleSettings{

	@SerializedName("defaultPage")
	private String defaultPage;

	public String getDefaultPage(){
		return defaultPage;
	}
}