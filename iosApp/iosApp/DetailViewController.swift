
import Foundation
import UIKit
import app

class DetailViewController : UIViewController, TalkDetailView {
    
    var talkId: String!
    var presenter: TalkDetailPresenter!
    
    override func viewDidLoad() {
        presenter = Container().talkDetailPresenter(talkId: talkId, view: self)
        presenter.onCreate()
    }
    
    func displayError(e: KotlinException) {
    }
    
    func displayTalk(talk: Talk) {
        self.navigationItem.title = talk.title
    }
}
