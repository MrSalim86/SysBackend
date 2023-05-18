package dtos;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private String userName;
    private String password;
    private List<RoleDTO> roleList = new ArrayList<>();

    public UserDTO(User user){
        this.userName = user.getUserName();
        this.password = user.getUserPass();
        this.roleList = user.getRoleList().stream().map(r -> new RoleDTO(r)).collect(Collectors.toList());

    }

    public UserDTO() {
    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static List<UserDTO> getDtos(List<User> persons) {
        return persons.stream().map(p -> new UserDTO(p)).collect(Collectors.toList());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDTO> roleList) {
        this.roleList = roleList;
    }

}
