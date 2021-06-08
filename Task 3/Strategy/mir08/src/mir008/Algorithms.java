package mir008;

public class Algorithms implements Strategy {
	@Override
	public void AutoPlay()
	{
		AutoPlay autoPlay = new AutoPlay();
		autoPlay.run();
	}
	@Override
	public void NonAutoPlay()
	{
		NonAutoPlay nonAutoPlay = new NonAutoPlay();
		nonAutoPlay.run();
	}
}
