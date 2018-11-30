import UIKit
import app

class ViewController: UIViewController, TalkListView, UITableViewDataSource, UITableViewDelegate {
    var presenter: TalkListPresenter!
    var talks: [TalkSummary]?
    
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var activityIndicator: UIActivityIndicatorView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter =  Container().talkListPresenter(view: self)
        
        presenter.onCreate()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func displayError(e: KotlinException) {
        e.printStackTrace()
    }
    
    func displayTalks(talks: [TalkSummary]) {
        self.talks = talks
        tableView.reloadData()
    }
    
    func displayLoading(b: Bool) {
        if b {
            activityIndicator.startAnimating()
        } else {
            activityIndicator.stopAnimating()
        }
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return talks?.count ?? 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "TalkCell") as! TalkTableViewCell
        let talk = talks![indexPath.row]
        cell.hoursLabel.text = talk.hourString
        cell.titleLabel.text = talk.title
        cell.subtitleLabel.text = talk.subtitle
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let talk = talks![indexPath.row]
        performSegue(withIdentifier: "showDetail", sender: talk.id)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let detailController = segue.destination as! DetailViewController
        detailController.talkId = sender as! String
    }
}

class TalkTableViewCell: UITableViewCell {
    
    @IBOutlet weak var hoursLabel: UILabel!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var subtitleLabel: UILabel!
}
