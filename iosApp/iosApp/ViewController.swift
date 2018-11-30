import UIKit
import app

class ViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var activityIndicator: UIActivityIndicatorView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func displayError(e: KotlinException) {
        e.printStackTrace()
    }

    
    func displayLoading(b: Bool) {
        if b {
            activityIndicator.startAnimating()
        } else {
            activityIndicator.stopAnimating()
        }
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "TalkCell") as! TalkTableViewCell

        cell.hoursLabel.text =  "hour"
        cell.titleLabel.text = "title"
        cell.subtitleLabel.text = "subtitle"
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "showDetail", sender: "talkId")
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let detailController = segue.destination as! DetailViewController
        detailController.talkId = sender as! String
    }

    func searchBar(_ searchBar: UISearchBar, textDidChange searchText: String) {
        
    }
}

class TalkTableViewCell: UITableViewCell {
    
    @IBOutlet weak var hoursLabel: UILabel!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var subtitleLabel: UILabel!
}
