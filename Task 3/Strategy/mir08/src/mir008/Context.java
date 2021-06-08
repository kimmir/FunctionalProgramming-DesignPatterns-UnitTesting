package mir008;

public class Context {
	Strategy strategy;

	public Context(Strategy strategy)
	{
		this.strategy = strategy;
	}
	public void NonAutoPlay()
	{
		strategy.NonAutoPlay();
	}
	public void AutoPlay()
	{
		strategy.AutoPlay();
	}
}
