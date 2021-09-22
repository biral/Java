Server Side Code:
package ServerFile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;
public class Server {
public final static int Port = 12345;
public static void main(String[] args) throws IOException {
DataInputStream is = null;
ServerSocket server = new ServerSocket(Port);
Socket sock_accept = new Socket();
System.out.println("Waiting for Connection:");
String data;
while(true)
{
try{
sock_accept = server.accept();
System.out.println("Connected:");
is = new DataInputStream(sock_accept.getInputStream());
data = is.readUTF();
System.out.println(data);
String[] data_array = data.split(":");
int[] data_process = new int[data_array.length];
for(int i=0;i<data_process.length;i++)
data_process[i]= Integer.parseInt(data_array[i]);
for(int i=0;i<data_process.length;i++)
System.out.println(data_process[i]);
System.out.println("Applying the Sort:");
Arrays.sort(data_process);
for(int i=0;i<data_process.length;i++)
{
System.out.println(data_process[i]);}

DataOutputStream send_array = new
DataOutputStream(sock_accept.getOutputStream());
send_array.writeInt(data_process.length);
for(int i=0;i<data_process.length;i++)
{
send_array.writeInt(data_process[i]);
}
}
finally{
}
}
}
}

Client Side Code:
package ServerFile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;import java.net.*;
import java.util.*;
public class Client {
public final static int Port = 12345;
public final static String Ip = "127.0.0.1";
public static void main(String[] args) throws Exception, IOException {
DataOutputStream os = null;
Socket client = new Socket(Ip,Port);
Scanner str = new Scanner(System.in);
String data;
String alldata = "";
int n;
while(true){
System.out.println("Enter the number of data to enter:");
n = str.nextInt();
for (int i=0;i<n;i++)
{System.out.println("Enter the data: "+i);
data = str.next();
if(i < n-1)

alldata += data + ":";

else
alldata += data;
}
System.out.println("Enter the data: "+ alldata);
os = new DataOutputStream(client.getOutputStream());
os.writeUTF(alldata);
os.flush();
DataInputStream receive_data = new DataInputStream(client.getInputStream());
int data_length = receive_data.readInt();
int[] sorted_data = new int[data_length];
for(int i=0;i<data_length;i++)
{
sorted_data[i] = receive_data.readInt();
}
System.out.println("The Sorted Data is:");
for (int i=0;i<data_length;i++)
{
System.out.println(sorted_data[i]);
}
os.close();
}
}
}
