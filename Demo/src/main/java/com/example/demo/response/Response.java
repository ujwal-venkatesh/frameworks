package com.example.demo.response;

public class Response<T> {
  String message;
  T response;
 
//public Response(int size, List<Employee> allEmployees) {
//// TODO Auto-generated constructor stub
//}
//
//public Response() {
//// TODO Auto-generated constructor stub
//}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public T getResponse() {
return response;
}
public void setResponse(T response) {
this.response = response;
}
}