package server.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class ApiRequestResponse {

    @XmlElement(name = "result_takeaction_pounds")
    private String[] resultTakeAction;



    @Override
    public String toString() {
        String returnString = "";
        for (String s : resultTakeAction) {
            returnString += s + ", ";
        }
        returnString = returnString.substring(0, returnString.length() - 2);
        return returnString;
    }
}
