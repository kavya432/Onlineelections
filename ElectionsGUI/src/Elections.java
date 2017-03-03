
public class Elections {
	private int ElectionID;
	private int cand1Vote;
	private int cand2Vote;
	private int cand3Vote;
	private String electionName;
	private String candidate1Name;
	private String candidate2Name;
	private String candidate3Name;
	
	
	 public Elections(String electionName, String candidate1Name, String candidate2Name, String candidate3Name, int cand1Vote, int cand2Vote, int cand3Vote){
   	  this.electionName = electionName;
   	  this.candidate1Name = candidate1Name;
   	  this.candidate2Name = candidate2Name;
   	  this.candidate3Name = candidate3Name;
   	  this.cand1Vote = cand1Vote;
   	  this.cand2Vote = cand2Vote;
   	  this.cand3Vote = cand3Vote;
     }

	public int getCand1Vote() {
			return cand1Vote;
		}

		public void setCand1Vote(int cand1Vote) {
			this.cand1Vote = cand1Vote;
		}

		public int getCand2Vote() {
			return cand2Vote;
		}

		public void setCand2Vote(int cand2Vote) {
			this.cand2Vote = cand2Vote;
		}

		public int getCand3Vote() {
			return cand3Vote;
		}

		public void setCand3Vote(int cand3Vote) {
			this.cand3Vote = cand3Vote;
		}


	public String getCandidate1Name() {
		return candidate1Name;
	}
	public void setCandidate1Name(String candidate1Name) {
		this.candidate1Name = candidate1Name;
	}
	public String getCandidate2Name() {
		return candidate2Name;
	}
	public void setCandidate2Name(String candidate2Name) {
		this.candidate2Name = candidate2Name;
	}
	public String getCandidate3Name() {
		return candidate3Name;
	}
	public void setCandidate3Name(String candidate3Name) {
		this.candidate3Name = candidate3Name;
	}
	
	public void candidate1VotesCount(int votes1){
		 cand1Vote = cand1Vote + votes1;
   	 
    }
	 public void candidate2VotesCount(int votes2){
		 cand2Vote = cand2Vote + votes2;
   	 
    }
	 public void candidate3VotesCount(int votes3){
		 cand3Vote = cand3Vote + votes3;
   	 
    }

	public String toString(){
		return this.electionName + ": " +candidate1Name+candidate2Name+candidate3Name;
	}

	public int getElectionID() {
		return ElectionID;
	}

	public void setElectionID(int electionID) {
		ElectionID = electionID;
	}

	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

	

}
