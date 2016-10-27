package ch.ethz.inf.vs.a3.message;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

import ch.ethz.inf.vs.a3.solution.clock.VectorClock;
import ch.ethz.inf.vs.a3.solution.message.Message;

/**
 * Message comparator class. Use with PriorityQueue.
 */
public class MessageComparator implements Comparator<Message> {


    @Override
    public int compare(Message lhs, Message rhs) {
        // retrieve timestamps of lhs and rhs
        System.out.println("inside comparator");
        try {
            JSONObject o = (JSONObject) lhs.getJSONObject().get("header");
            System.out.println("JSON IS " + o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            String s1 = (String) ((JSONObject) lhs.getJSONObject().get("header")).get("timestamp");
            String s2 = (String) ((JSONObject) rhs.getJSONObject().get("header")).get("timestamp");
            System.out.println("1st Arg is " + s1 + " and " );
            System.out.println("2st Arg is " + s1 + " and " );
            VectorClock c1 = new VectorClock();
            c1.setClockFromString(s1);
            VectorClock c2 = new VectorClock();
            c2.setClockFromString(s2);

            System.out.println("1st Arg is " + s1 + " and " + c1.toString());
            System.out.println("2st Arg is " + s1 + " and " + c1.toString());

            if (c1.happenedBefore(c2)) {
                return -1;
            } else if (c2.happenedBefore(c1)) {
                return 1;

            } else {
                return 0;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }


}
