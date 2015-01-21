package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken; 

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Type;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<String> adapter;//debug
	private ArrayList<String> tweets;//debug
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				saveInFile(text, new Date(System.currentTimeMillis()));
				if(tweets==null)
				{
					tweets = new ArrayList<String>();
				}
				//finish();
				tweets.add(text);//debug
				adapter.notifyDataSetChanged();//debug

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		//User u = new author("Joe");
		
		//.getName();
		
		
		
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Object> objects;
		
		
		super.onStart();
		//String[] 
		tweets = loadFromFile();
		//ArrayAdapter<String>  //debug
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<String> loadFromFile() {
		Gson gson = new Gson();
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader in = new InputStreamReader(fis);//(new InputStreamReader(fis));
			//Taken from 
			Type typeOfT = new TypeToken<ArrayList<String>>(){}.getType();
			tweets=gson.fromJson(in, typeOfT);
			fis.close();
			/*
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}
			*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;//.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile(String text, Date date) {
		Gson gson = new Gson();//new data
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);//Context.MODE_APPEND);
			
			OutputStreamWriter osw= new OutputStreamWriter(fos);// new
			gson.toJson(tweets, osw);//new
			osw.flush();
			
			//fos.write(new String(date.toString() + " | " + text)
			//		.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}