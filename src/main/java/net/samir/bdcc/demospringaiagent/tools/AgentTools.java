package net.samir.bdcc.demospringaiagent.tools;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class AgentTools {

    @Tool(description = "Get Info about an Employee")
    public EmployeeInfo getEmployeeInfo(@ToolParam(description = "Employee Name") String employeeName) {
        return new EmployeeInfo(
                employeeName,13000,2
        );
    }

}


 record EmployeeInfo( String name,double salary , int seniority) {}
