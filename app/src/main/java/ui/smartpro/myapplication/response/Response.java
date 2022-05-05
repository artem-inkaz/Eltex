package ui.smartpro.myapplication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response implements Parcelable {

	@SerializedName("houseIds")
	private List<String> houseIds;

	@SerializedName("emailConfirm")
	private boolean emailConfirm;

	@SerializedName("access")
	private Access access;

	@SerializedName("role")
	private String role;

	@SerializedName("admin")
	private boolean admin;

	@SerializedName("language")
	private String language;

	@SerializedName("ownedHouseIds")
	private List<String> ownedHouseIds;

	@SerializedName("houseIdsWithRefuser")
	private List<String> houseIdsWithRefuser;

	@SerializedName("enabled")
	private boolean enabled;

	@SerializedName("platforms")
	private Object platforms;

	@SerializedName("phoneConfirm")
	private boolean phoneConfirm;

	@SerializedName("password")
	private Object password;

	@SerializedName("surname")
	private String surname;

	@SerializedName("permissions")
	private List<String> permissions;

	@SerializedName("id")
	private String id;

	@SerializedName("email")
	private Object email;

	@SerializedName("externalUrl")
	private String externalUrl;

	@SerializedName("additionalAccounts")
	private AdditionalAccounts additionalAccounts;

	@SerializedName("roleSettings")
	private RoleSettings roleSettings;

	@SerializedName("roleId")
	private String roleId;

	@SerializedName("videoParametersByPlatform")
	private Object videoParametersByPlatform;

	@SerializedName("patronymic")
	private String patronymic;

	@SerializedName("additionalEmail")
	private Object additionalEmail;

	@SerializedName("phone")
	private Object phone;

	@SerializedName("accessMap")
	private AccessMap accessMap;

	@SerializedName("videoParameters")
	private Object videoParameters;

	@SerializedName("roleName")
	private String roleName;

	@SerializedName("name")
	private String name;

	@SerializedName("username")
	private String username;

	@SerializedName("status")
	private String status;

	public List<String> getHouseIds(){
		return houseIds;
	}

	public boolean isEmailConfirm(){
		return emailConfirm;
	}

	public Access getAccess(){
		return access;
	}

	public String getRole(){
		return role;
	}

	public boolean isAdmin(){
		return admin;
	}

	public String getLanguage(){
		return language;
	}

	public List<String> getOwnedHouseIds(){
		return ownedHouseIds;
	}

	public List<String> getHouseIdsWithRefuser(){
		return houseIdsWithRefuser;
	}

	public boolean isEnabled(){
		return enabled;
	}

	public Object getPlatforms(){
		return platforms;
	}

	public boolean isPhoneConfirm(){
		return phoneConfirm;
	}

	public Object getPassword(){
		return password;
	}

	public String getSurname(){
		return surname;
	}

	public List<String> getPermissions(){
		return permissions;
	}

	public String getId(){
		return id;
	}

	public Object getEmail(){
		return email;
	}

	public String getExternalUrl(){
		return externalUrl;
	}

	public AdditionalAccounts getAdditionalAccounts(){
		return additionalAccounts;
	}

	public RoleSettings getRoleSettings(){
		return roleSettings;
	}

	public String getRoleId(){
		return roleId;
	}

	public Object getVideoParametersByPlatform(){
		return videoParametersByPlatform;
	}

	public String getPatronymic(){
		return patronymic;
	}

	public Object getAdditionalEmail(){
		return additionalEmail;
	}

	public Object getPhone(){
		return phone;
	}

	public AccessMap getAccessMap(){
		return accessMap;
	}

	public Object getVideoParameters(){
		return videoParameters;
	}

	public String getRoleName(){
		return roleName;
	}

	public String getName(){
		return name;
	}

	public String getUsername(){
		return username;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {

	}
}