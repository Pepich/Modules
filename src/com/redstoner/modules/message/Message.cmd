command message {
    alias m;
    alias em;
    alias msg;
    alias emsg;
    alias t;
    alias et;
    alias tell;
    alias etell;
    alias w;
    alias ew;
    alias whisper;
    alias ewhisper;
    [string:player] [string:message...] {
        run message player message;
        help Sends a direct message to a player.;
        perm utils.message;
    }
}

command reply {
    alias r;
    alias er;
    alias ereply;
    [string:message...] {
        run reply message;
        help Sends a direct message to the last person you talked to.;
        perm utils.message;
    }
}