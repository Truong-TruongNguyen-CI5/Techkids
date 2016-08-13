package controllers.Bombs;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 8/10/2016.
 */


public class NotificationCenter {
    private Vector<BombSubscriber> subscribers;
    private Vector<FreezeSubcriber> freezeSubcribers;

    public NotificationCenter() {
        subscribers = new Vector<BombSubscriber>();
        freezeSubcribers = new Vector<FreezeSubcriber>();
    }

    public void subsribe(BombSubscriber bombSubscriber) {
        subscribers.add(bombSubscriber);
    }

    public void subsribeFrezze(FreezeSubcriber freezeSubcriber) {
        freezeSubcribers.add(freezeSubcriber);
    }

    public void onBomExpode(int x, int y) {
        Iterator<BombSubscriber> bombSubscriberIterator = subscribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if(!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                bombSubscriber.onBombExplode();
            }
        }
    }

    public void onFrezze(int x, int y) {
        Iterator<FreezeSubcriber> freezeSubcriberIterator = freezeSubcribers.iterator();
        while(freezeSubcriberIterator.hasNext()) {
            FreezeSubcriber freezeSubcriber = freezeSubcriberIterator.next();
            if(!freezeSubcriber.getGameObject().isAlive()) {
                freezeSubcriberIterator.remove();
            } else{
                freezeSubcriber.onFreeze();
            }
        }
    }

    public static final NotificationCenter instance = new NotificationCenter();
}
