package org.wahlzeit.model;

import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.Language;

import java.net.URL;

public class GamePhoto extends Photo{

    private Game game = null;

    public static final String IMAGE = "image";
    public static final String THUMB = "thumb";
    public static final String LINK = "link";
    public static final String PRAISE = "praise";
    public static final String NO_VOTES = "noVotes";
    public static final String CAPTION = "caption";
    public static final String DESCRIPTION = "description";
    public static final String KEYWORDS = "keywords";

    public static final String TAGS = "tags";

    public static final String STATUS = "status";
    public static final String IS_INVISIBLE = "isInvisible";
    public static final String UPLOADED_ON = "uploadedOn";

    /**
     *
     */
    public static final int MAX_PHOTO_WIDTH = 420;
    public static final int MAX_PHOTO_HEIGHT = 600;
    public static final int MAX_THUMB_PHOTO_WIDTH = 105;
    public static final int MAX_THUMB_PHOTO_HEIGHT = 150;

    /**
     *
     */
    protected PhotoId id = null;

    /**
     *
     */
    protected int ownerId = 0;
    protected String ownerName;
    protected Location location;
    /**
     *
     */
    protected boolean ownerNotifyAboutPraise = false;
    protected EmailAddress ownerEmailAddress = EmailAddress.EMPTY;
    protected Language ownerLanguage = Language.ENGLISH;
    protected URL ownerHomePage;

    /**
     *
     */
    protected int width;
    protected int height;
    protected PhotoSize maxPhotoSize = PhotoSize.MEDIUM; // derived

    /**
     *
     */
    protected Tags tags = Tags.EMPTY_TAGS;

    /**
     *
     */
    protected PhotoStatus status = PhotoStatus.VISIBLE;

    /**
     *
     */
    protected int praiseSum = 10;
    protected int noVotes = 1;

    /**
     *
     */
    protected long creationTime = System.currentTimeMillis();

    public GamePhoto(){
        id = PhotoId.getNextId();
        incWriteCount();
    }

    public GamePhoto(PhotoId pid){
        // no need to check for exceptions, super-class handles that
        super(pid);
    }

    public GamePhoto(Location loc){
        // no need to check for exceptions, super-class handles that
        super(loc);
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
