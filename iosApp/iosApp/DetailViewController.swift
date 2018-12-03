
import Foundation
import UIKit
import app

class DetailViewController : UIViewController, TalkDetailView {
    
    var talkId: String!
    var presenter: TalkDetailPresenter!
    
    @IBOutlet weak var speakersLabel: UILabel!
    @IBOutlet weak var hoursLabel: UILabel!
    @IBOutlet weak var roomAndTechLabel: UILabel!
    @IBOutlet weak var descriptionTextView: UITextView!
    
    override func viewDidLoad() {
        descriptionTextView.textContainerInset = .zero
        descriptionTextView.textContainer.lineFragmentPadding = 0
        presenter = Container().talkDetailPresenter(talkId: talkId, view: self)
        presenter.onCreate()
    }
    
    func displayError(e: KotlinException) {
    }
    
    func displayTalk(talk: TalkDetail) {
        self.navigationItem.title = talk.title
        self.speakersLabel.text = talk.speakersString
        self.hoursLabel.text = talk.hourString
        self.roomAndTechLabel.text = talk.roomAndTechString
        self.descriptionTextView.text = talk.descriptionString
    }
}
