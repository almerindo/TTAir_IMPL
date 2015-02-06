package org.ttair.proccess.impl;

import java.util.ArrayList;
import java.util.List;

import org.ttair.TTAirEvent;
import org.ttair.dataaccess.DeviceManager;
import org.ttair.presentation.architecture.IUserStreamListener;
import org.ttair.proccess.architecture.ANodeRecognizer;

import com.primesense.nite.UserData;
import com.primesense.nite.UserTrackerFrameRef;

public class RecognizerKinectNewUser extends ANodeRecognizer implements IUserStreamListener{


	private static final long serialVersionUID = 4520618749231529127L;
	public static final String[] EventCod= {"EVTNewUser"};
	
	
    int[] mColors;

    boolean anterior = false;
    boolean novo = false;
    private TTAirEvent evt = null;

   
   
    int id = -9999; //
    List<Short> idUsers = new ArrayList<Short>();
    
	private boolean notified;
	private UserTrackerFrameRef userframe;

    public RecognizerKinectNewUser(){
    	DeviceManager.getTTAirDevice().addListenerUserStream(this);
    	DeviceManager.getTTAirDevice().getUserTracker();
    	//idUsers.add(2);
    }

    @Override
    public synchronized TTAirEvent toExecute() {
    	if (!this.notified) {
    		return null;
    	}
    	
    	List<UserData> users = this.userframe.getUsers();
    
    	this.evt = null;
    	if(users!=null) {
    		for (int i = 0; i < users.size(); i++) {
    			UserData user = users.get(i);
    			if (user.isVisible()){
    				if (!this.idUsers.contains(user.getId())) {
    					
    					this.idUsers.add(user.getId());
    					//System.out.println("Size users "+this.idUsers.size());
    					this.evt = new TTAirEvent(this);
    					try {
    						this.evt.setCOD(RecognizerKinectNewUser.EventCod[0]);
    						this.evt.setParam(user.getId());
    						System.out.println("NEW User ID: " + user.getId());

    					} catch (Exception e) {
    						e.printStackTrace();
    					}
    					this.evt.setParam(user);
    				}
    			}else{
    				this.evt = null;
    			}
    		}
    	}
    	this.notified = false;
    	return this.evt;

    }

	@Override
	public void notify(UserTrackerFrameRef frame) {
		//System.out.println("Notificado de novo usuário");
		this.notified = true;
		this.userframe = frame;
		
	}





}
