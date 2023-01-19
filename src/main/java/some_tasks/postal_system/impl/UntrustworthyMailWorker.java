package some_tasks.postal_system.impl;

/*
 a class that models an untrusted mail worker that, instead of passing the mail object directly to the mail service,
 passes the mail object sequentially to a set of third parties,
 and then finally passes the resulting object directly to the RealMailService instance.
 The UntrustworthyMailWorker must have a constructor from the MailService array
 (the result of calling processMail on the first element of the array is passed to the input of processMail on the second element, and so on) and a getRealMailService method that
  returns a reference to the internal RealMailService instance.
 */


import some_tasks.postal_system.service.MailService;
import some_tasks.postal_system.service.RealMailService;

public class UntrustworthyMailWorker {
   private RealMailService realMailService;
   private MailService[] mailServices;

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
        for (MailService ms : this.mailServices) {
            if (ms instanceof RealMailService)
                this.realMailService = (RealMailService)ms;
        }
        if (this.realMailService == null) {
            this.realMailService = new RealMailService();
        }
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}
