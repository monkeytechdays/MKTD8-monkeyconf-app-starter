
import Foundation
import UIKit
import app

class DetailViewController : UIViewController {
    
    var talkId: String!
    
    @IBOutlet weak var speakersLabel: UILabel!
    @IBOutlet weak var hoursLabel: UILabel!
    @IBOutlet weak var roomAndTechLabel: UILabel!
    @IBOutlet weak var descriptionTextView: UITextView!
    
    override func viewDidLoad() {
        descriptionTextView.textContainerInset = .zero
        descriptionTextView.textContainer.lineFragmentPadding = 0
        sampleDisplayTalk()
    }
    
    func displayError(e: KotlinException) {
    }
    
    func sampleDisplayTalk() {
        self.navigationItem.title = "title"
        self.speakersLabel.text = "speakers"
        self.hoursLabel.text = "hours"
        self.roomAndTechLabel.text = "roomAndTech"
        self.descriptionTextView.text = "description"
    }
}
